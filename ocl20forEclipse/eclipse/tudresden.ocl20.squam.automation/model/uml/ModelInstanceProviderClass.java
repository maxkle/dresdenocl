package uml;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franz Eichhorn
 */
public class ModelInstanceProviderClass {


	public static List<Object> getModelObjects() {

		List<Object> result;

		

		result = new ArrayList<Object>();
		result.add(new Model());
		
		return result;
	}
}