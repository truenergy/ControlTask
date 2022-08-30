package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;
import java.util.List;
import by.tc.task01.dao.ExceptionDAO;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.print.ServicePrintInfo;

public class Main {

	public static void main(String[] args) throws ServiceException, ExceptionDAO {

		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.CAPACITY.toString(), 32);
		criteriaOven.add(Oven.POWER_CONSUMPTION.toString(), 15);
		criteriaOven.add(Oven.WEIGHT.toString(), "hhh");

		appliances = service.find(criteriaOven);
		PrintApplianceInfo.print(appliances);
		//ServicePrintInfo.printOutput(appliances);

	}
}
