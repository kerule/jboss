package local.test.beans;

import static junit.framework.Assert.*;

import javax.validation.constraints.AssertTrue;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class IndexTest {

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive web = ShrinkWrap.create(WebArchive.class);
		Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies();
		/**
		return ShrinkWrap.create(MavenImporter.class)
				.loadPomFromFile("/path/to/pom.xml").importBuildOutput().as(WebArchive.class);
				**/
		web.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve().withoutTransitivity().asFile());
		System.out.println(web.toString(true));
		return web;
		
	}

	@Test
	public void should_create_greeting() {
		assertTrue(true);
	}
}
