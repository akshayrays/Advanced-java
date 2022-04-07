package JavaBean_Marksheet;

public class TestGet {

	public static void main(String[] args) throws Exception {
		testget();
	}

	private static void testget() throws Exception {

		Marksheet_Bean bean = new Marksheet_Bean();
		bean.setRollno("3");

		Model_GET mg = new Model_GET();
		mg.get(bean);
	}
}
