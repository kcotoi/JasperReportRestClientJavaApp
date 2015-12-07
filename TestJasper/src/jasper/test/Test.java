package jasper.test;

public class Test {

	public static void main(String[] args) {

		UsersService restClient = new UsersService();

		restClient.before();
		restClient.createNewUsers();
		restClient.after();

	}

}
