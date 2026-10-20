import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		service.addContact(contact);
		
		assertDoesNotThrow(() -> service.deleteContact("1234567890"));
	}
	
	@Test
	public void testDuplicateAddContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");

		Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");

		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact1);
		});
	}
	
	@Test
	public void testDeleteContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		service.deleteContact("1234567890");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("1234567890");
		});
	}
	
	@Test
	public void testDeleteNonexistentContact() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("1234567890");
		});
	}
	
	@Test
	public void testUpdateFirstName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		service.UpdateContact("1234567890", "Jane", "Doe", "1234567890", "123 John Doe Street");
		
		assertEquals("Jane", contact.getFirstName());
	}
	
	@Test
	public void testUpdateLastName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		service.UpdateContact("1234567890", "John", "Smith", "1234567890", "123 John Doe Street");
		
		assertEquals("Smith", contact.getLastName());
	}
	
	@Test
	public void testUpdatePhone() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		service.UpdateContact("1234567890", "John", "Doe", "0987654321", "123 John Doe Street");
		
		assertEquals("0987654321", contact.getPhone());
	}
	
	@Test
	public void testUpdateAddress() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		service.UpdateContact("1234567890", "John", "Doe", "0987654321", "321 Jane Smith Road");
		
		assertEquals("321 Jane Smith Road", contact.getAddress());
	}
	
	@Test
	public void testUpdateNonexistentContact() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateContact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testInvalidFirstNameUpdate() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateContact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testInvalidLastNameUpdate() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateContact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testInvalidPhoneUpdate() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateContact("1234567890", "John", "Doe", "12345678901234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testInvalidAddressUpdate() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateContact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street 123 John Doe Street 123 John Doe Street");
		});
	}
	
}