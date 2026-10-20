import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	@Test
	public void testValidContact() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		
		assertEquals("1234567890", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 John Doe Street", contact.getAddress());
	}
	
	@Test
	public void testNullContactId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testLongContactId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Doe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testLongFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testNullLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", null, "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testLongLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testNullPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", null, "123 John Doe Street");
		});
	}
	
	@Test
	public void testLongPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "12345678901234567890", "123 John Doe Street");
		});
	}
	
	@Test
	public void testShortPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "1", "123 John Doe Street");
		});
	}
	
	@Test
	public void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "123-456-789", "123 John Doe Street");
		});
	}
	
	@Test
	public void testNullAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "1234567890", null);
		});
	}
	
	@Test
	public void testLongAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street 123 John Doe Street");
		});
	}
	
	@Test
	public void testUpdateFirstName() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		contact.setFirstName("Jane");
		assertEquals("Jane", contact.getFirstName());
	}
	
	@Test
	public void testUpdateLastName() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		contact.setLastName("Smith");
		assertEquals("Smith", contact.getLastName());
	}
	
	@Test
	public void testUpdatePhone() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		contact.setPhone("0987654321");
		assertEquals("0987654321", contact.getPhone());
	}
	
	@Test
	public void testUpdateAddress() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		contact.setAddress("321 Doe John Street");
		assertEquals("321 Doe John Street", contact.getAddress());
	}
	
	@Test
	public void testInvalidFirstNameUpdate() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("JohnJohnJohn");
		});
	}
	
	@Test
	public void testInvalidLastNameUpdate() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("DoeDoeDoeDoe");
		});
	}
	
	@Test
	public void testInvalidPhoneUpdate() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("12345678901234567890");
		});
	}
	
	@Test
	public void testInvalidAddressUpdate() {
		Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 John Doe Street");
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("123 John Doe Street 123 John Doe Street 123 John Doe Street");
		});
	}
	
	
}