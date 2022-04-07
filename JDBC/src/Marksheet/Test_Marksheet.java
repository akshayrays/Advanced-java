package Marksheet;

public class Test_Marksheet {

	public static void main(String[] args) throws Exception {
		testAdd();

	}

	private static void testAdd() throws Exception {

		Marksheet_Bean bean = new Marksheet_Bean();
		bean.setId(1);
		bean.setRollno("Dhoom 01");
		bean.setFname("John");
		bean.setLname("Baba");
		bean.setPhy(50);
		bean.setChem(70);
		bean.setMat(90);

		Marksheet_Model model = new Marksheet_Model();
		model.Add(bean);

	}

}
