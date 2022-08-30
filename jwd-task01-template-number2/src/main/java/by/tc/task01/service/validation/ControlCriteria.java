package by.tc.task01.service.validation;

import java.util.Map;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

public class ControlCriteria {

	public static boolean criteriaValidator(Criteria criteria, String appliance) {

		boolean flag = false;
		if (!appliance.equals("")) {

			if (appliance.equalsIgnoreCase(criteria.getGroupSearchName()) == true) {
				flag = true;
				return flag;
			}
		}

		return flag;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean validatorOvenNew(Criteria criteria) { /// проверка по типу значения (строка/число)
		boolean flag = false;

		for (Map.Entry<String, Object> ovenCriteria : criteria.getCriteria().entrySet()) {

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.CAPACITY.toString())) {
				if (ovenCriteria.getValue().getClass() != String.class) {
					flag = true;
				}
			}

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {
				if (ovenCriteria.getValue().getClass() != String.class) {
					flag = true;

				}

			}
			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.DEPTH.toString())) {
				if (ovenCriteria.getValue().getClass() != String.class) {
					flag = true;
				}

			}
			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.WEIGHT.toString())) {
				if (ovenCriteria.getValue().getClass() != String.class) {
					flag = true;
				}

			}
			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.WIDTH.toString())) {
				if (ovenCriteria.getValue().getClass() != String.class) {
					flag = true;
				}

			}
			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.HEIGHT.toString())) {
				if (ovenCriteria.getValue().getClass() != String.class) {
					flag = true;
				}

			}

		}
		return flag;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public static boolean validatorOvenControl(Criteria criteria) { // проверка по введенному значению, тип значения и
																	// значение (отрицательное и пр) //
																	// большое/маленькое)

		boolean flag = false;

		for (Map.Entry<String, Object> ovenCriteria : criteria.getCriteria().entrySet()) {

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.CAPACITY.toString())) {
				if (ovenCriteria.getValue().getClass() == Integer.class) {
					flag = true;
					if (flag == true) {
						int intValue = Integer.parseInt(ovenCriteria.getValue().toString());
						//System.out.println(intValue);
						if ((intValue < 0) && (intValue > 40)) {
							flag = false;

						}

					}

				}
			}
			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.POWER_CONSUMPTION.toString())) {

				if (ovenCriteria.getValue().getClass() == Integer.class) {
					flag = true;
					if (flag == true) {
						int intValue = Integer.parseInt(ovenCriteria.getValue().toString());
						if ((intValue > 0) && (intValue < 2001)) {
							flag = true;
						} else {
							flag = false;
						}
					}
				}
			}

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.WEIGHT.toString())) {
				if (ovenCriteria.getValue().getClass() == Integer.class) {
					flag = true;
					if (flag == true) {
						int intValue = Integer.parseInt(ovenCriteria.getValue().toString());
						if ((intValue > 0) && (intValue < 14)) {
							flag = true;
						} else {
							flag = false;
						}
					}
				}
			}

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.DEPTH.toString())) {
				if (ovenCriteria.getValue().getClass() == Integer.class) {
					flag = true;
					if (flag == true) {
						int intValue = Integer.parseInt(ovenCriteria.getValue().toString());
						if ((intValue > 0) && (intValue < 61)) {
							flag = true;
						} else {
							flag = false;
						}
					}
				}
			}

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.HEIGHT.toString())) {
				if (ovenCriteria.getValue().getClass() == Double.class) {
					flag = true;
					if (flag == true) {
						double doubleValue = Double.parseDouble(ovenCriteria.getValue().toString());
						if ((doubleValue > 0.0) && (doubleValue < 50.0)) {
							flag = true;
						} else {
							flag = false;
						}
					}
				}
			}

			if (ovenCriteria.getKey().toString().equals(SearchCriteria.Oven.WIDTH.toString())) {
				if (ovenCriteria.getValue().getClass() == Double.class) {
					flag = true;
					if (flag == true) {
						double doubleValue = Double.parseDouble(ovenCriteria.getValue().toString());
						if ((doubleValue > 0.0) && (doubleValue < 71.0)) {
							flag = true;
						} else {
							flag = false;
						}
					}
				}
			}

		}
		//System.out.println(flag);
		return flag;

	}
}