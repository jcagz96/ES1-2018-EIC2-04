package JUnitTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import RedesSociais.Destaques;
import RedesSociais.Facebook;
import RedesSociais.Gmail;
import RedesSociais.PostGeral;
import RedesSociais.TwitterObject;

public class DestaquesTest {
	
	private Destaques destaques;
	
	@Before
	public void setUp() {
		Gmail gm = new Gmail();
		Facebook fb = new Facebook();
		TwitterObject tw = new TwitterObject();
		this.destaques = new Destaques(gm.getLista_posts(), fb.getLista_posts(), tw.getLista_posts());
	}
	
	@Test
	public void test_getDestaques() {
		for(PostGeral post: destaques.getDestaques()) {
			assertNotNull(post);
		}
	}
	
	@Test
	public void test_setDestaques() { 
		destaques.setDestaques(destaques.getDestaques());
		for(PostGeral post: destaques.getDestaques()) {
			assertNotNull(post);
		}
		
	}
	
	@Test
	public void test_palavraChave() {
		ArrayList<PostGeral> lista = destaques.palavraChave("EIC", destaques.getDestaques());
		for(PostGeral post: lista) {
			assertNotNull(post);
		}
	}
	
	@Test
	public void test_vinteQuatroHoras() {
		ArrayList<PostGeral> lista = destaques.vinteQuatroHoras(destaques.getDestaques());
		assertTrue(lista.size() >= 0);
	}
	
	@Test
	public void test_getPostEspecifico() {
		String titulo = "[Twitter] Mon Dec 03 18:14:55 GMT 2018 - SL Benfica";
		PostGeral post = destaques.getPostEspecifico(titulo);
		assertTrue(post.createTitulo().equals(titulo));
	}
	
	@Test
	public void test_viraLista() {
		ArrayList<PostGeral> lista = destaques.viraLista(destaques.getDestaques());
		assertTrue(lista.size() == destaques.getDestaques().size());
	}
	
	
	
	
	
	
}