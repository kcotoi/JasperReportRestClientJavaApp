package jasper.test;

import com.jaspersoft.jasperserver.dto.authority.ClientUser;
import com.jaspersoft.jasperserver.jaxrs.client.core.operationresult.OperationResult;

/**
 * @author Alexander Krasnyanskiy
 */
public class UsersService extends RestClientUtil {

	private ClientUser user;

	public void before() {
		initClient();
		initSession();
		user = new ClientUser().setUsername("test_user").setPassword("test_password")
				.setEmailAddress("john.doe@email.net").setEnabled(true).setExternallyDefined(false)
				.setFullName("John Doe");
	}

	public void createNewUsers() {

		OperationResult<ClientUser> operationResult = session.usersService().user(user).createOrUpdate(user);

		ClientUser entity = operationResult.getEntity();

		System.out.println("ME2: " + entity.getFullName());

	}

	public void after() {
		session.logout();
		session = null;
	}

}