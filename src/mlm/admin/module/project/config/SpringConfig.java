package mlm.admin.module.project.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(value="mlm.admin.module.project")
@PropertySource(value= {"classpath:database.properties"})
public class SpringConfig implements WebMvcConfigurer
{
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		return view;
	}
	
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		System.out.println("\n JDBC PROPERTIES LOADED SUCCESSFULLY");
		return ds;
	}
	
	
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		System.out.println("\n JDBC TEMPLATE LOADED SUCCESSFULLY");
		return jdbcTemplate;
	}
	
	
	@Bean
    public JavaMailSender getMailSender()
	{
		
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
         
        //Using gmail
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("kmoshd@gmail.com");
        mailSender.setPassword("mynameismoshkhan");
         
        Properties javaMailProperties = new Properties();
        
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
         
        mailSender.setJavaMailProperties(javaMailProperties);
        
        return mailSender;
    }
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry
				.addResourceHandler("/resources/**")
													.addResourceLocations("/resources/");
	}

}
