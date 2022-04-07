package JavaBean_Marksheet;

public class Delete_Test {

	public static void main(String[] args) throws Exception {
		TestDelete();

	}

	private static void TestDelete() throws Exception {
		Marksheet_Bean bean = new Marksheet_Bean();

		bean.setId(4);

		Marksheet_Model_delete dele = new Marksheet_Model_delete();
		dele.Delete(bean);

	}
}
