package JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import RedesSociais.Facebook;
import RedesSociais.FacebookPost;

class FacebookTest {

	
	
	
	@Test
	void test_addPostsToArray() throws ParserConfigurationException, SAXException, IOException {
		
		Facebook fb1 = new Facebook();
		
		ArrayList<FacebookPost> listPosts1 = fb1.getPosts();

		assertEquals(listPosts1.size(), fb1.getPosts().size());
		
	}
	
	
	


}
