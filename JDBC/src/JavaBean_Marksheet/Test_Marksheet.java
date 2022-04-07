package JavaBean_Marksheet;

import java.util.Iterator;
import java.util.List;

public class Test_Marksheet {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// TestDelete();
		// testget();
		testmeritlist();

	}

	private static void testAdd() throws Exception {

		Marksheet_Bean bean = new Marksheet_Bean();
		bean.setId(9);
		bean.setRollno("7");
		bean.setFname("Shyam");
		bean.setLname("Sharma");
		bean.setPhy(50);
		bean.setChem(70);
		bean.setMaths(90);

		Marksheet_Model model = new Marksheet_Model();
		model.Add(bean);

	}

	private static void testUpdate() throws Exception {
		Marksheet_Bean bean = new Marksheet_Bean();

		bean.setId(1);
		bean.setFname("Shyam");

		Model_Update md = new Model_Update();
		md.Add(bean);
	}

	private static void TestDelete() throws Exception {
		Marksheet_Bean bean = new Marksheet_Bean();

		bean.setId(9);

		Marksheet_Model dele = new Marksheet_Model();
		dele.Delete(bean);
		System.out.println("me delete hu");
	}

	private static void testmeritlist() throws Exception {
		Marksheet_Model model = new Marksheet_Model();

		List list = model.getMeritList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Marksheet_Bean bean1 = (Marksheet_Bean) it.next();

			System.out.println(bean1.getId());
			System.out.print("\t" + bean1.getRollno());
			System.out.print("\t" + bean1.getFname());
			System.out.print("\t" + bean1.getLname());
			System.out.print("\t" + bean1.getPhy());
			System.out.print("\t" + bean1.getChem());
			System.out.print(bean1.getMaths());

		}
	}

}