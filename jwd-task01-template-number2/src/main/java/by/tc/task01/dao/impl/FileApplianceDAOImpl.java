package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import by.tc.task01.dao.ApplianceDAO;

import by.tc.task01.dao.ExceptionDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;

public class FileApplianceDAOImpl implements ApplianceDAO {
	private final String text = "appliances_db.txt";

	@Override
	public List<Appliance> find(Criteria criteria) throws ExceptionDAO {

		Map<String, Object> storageCriteria = criteria.getCriteria();
		Set<String> storageAppliance = new HashSet();
		String value;

		ClassLoader loader = FileApplianceDAOImpl.class.getClassLoader();
		File dataFile = new File(loader.getResource(text).getFile());
		//FileReader fileReader = null;
		// BufferedReader reader = null;
		String dataLine;

		try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
			dataLine = reader.readLine();

			while (dataLine != null) {
				// System.out.println(line);
				if (dataLine.contains(criteria.getGroupSearchName())) {
					for (Map.Entry<String, Object> temp : storageCriteria.entrySet()) {
						value = temp.getKey() + "=" + temp.getValue();
						if (dataLine.contains(value)) {
							storageAppliance.add(dataLine);
						}
					}
				}
				dataLine = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			throw new ExceptionDAO(e);
		} catch (IOException e) {
			throw new ExceptionDAO(e);
		}

		return findNew(storageAppliance);
	}

	private List<Appliance> findNew(Set<String> storageAppliance) {

		List<Appliance> criteriaAppliance = new ArrayList<Appliance>();
		FileLogicDAO logic = FileLogicDAO.getInstance();

		String[] splitLine;

		for (String temp : storageAppliance) {

			splitLine = logic.splitLineCriteria(temp);
			String nameObject = splitLine[0].trim();
			if (nameObject.equals(Laptop.class.getSimpleName())) {
				criteriaAppliance.add(logic.criteriaLaptop(splitLine));
			} else if (nameObject.equals(Oven.class.getSimpleName())) {
				criteriaAppliance.add(logic.criteriaOven(splitLine));
			} else if (nameObject.equals(Refrigerator.class.getSimpleName())) {
				criteriaAppliance.add(logic.criteriaRefrigerator(splitLine));
			} else if (nameObject.equals(Speakers.class.getSimpleName())) {
				criteriaAppliance.add(logic.criteriaSpeakers(splitLine));
			} else if (nameObject.equals(TabletPC.class.getSimpleName())) {
				criteriaAppliance.add(logic.criteriaTabletPC(splitLine));
			} else if (nameObject.equals(VacuumCleaner.class.getSimpleName())) {
				criteriaAppliance.add(logic.criteriaVacuumCl(splitLine));
			}
		}

		return criteriaAppliance;
	}

}
