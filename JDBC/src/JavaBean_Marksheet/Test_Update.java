package JavaBean_Marksheet;

public class Test_Update {
	public static void main(String[] args) throws Exception {
		testAdd();
	}

	private static void testAdd() throws Exception {
		Marksheet_Bean bean = new Marksheet_Bean();

		bean.setId(1);
		bean.setFname("Johny");

		Model_Update md = new Model_Update();
		md.Add(bean);
	}
}
