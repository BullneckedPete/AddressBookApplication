import Addressbook.AddressBook;
import Addressbook.Entries.*;
import Addressbook.Commands.*;
import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestExport {
	
	private AddressBook testAddressBook;
	private Search search;

	private BufferedReader bw;
	private Export testExport;
	
	@Before
	public void setUp() {


		testAddressBook = new AddressBook();
		search = new Search("search name:elv", testAddressBook);
		testExport = new Export(search);

		try {
			testExport.export(search);
		}
		catch (IOException e){
			e.getMessage();
		}
	}
	
	@Test
	public void testCreateFile() {
		assertTrue(testExport.getFile().exists());
		assertEquals((testExport.getFile()).getName(), "exportedData.csv");
	}

	
}
