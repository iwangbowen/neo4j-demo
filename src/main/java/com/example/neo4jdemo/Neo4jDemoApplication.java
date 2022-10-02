package com.example.neo4jdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.neo4jdemo.domains.Menu;
import com.example.neo4jdemo.domains.MenuProjection;
import com.example.neo4jdemo.domains.Song;
import com.example.neo4jdemo.domains.User;
import com.example.neo4jdemo.repositories.MenuRepository;
import com.example.neo4jdemo.repositories.SongRepository;
import com.example.neo4jdemo.repositories.UserRepository;

@SpringBootApplication
public class Neo4jDemoApplication implements CommandLineRunner {

	private final SongRepository songRepository;

	private final MenuRepository menuRepository;

	private final UserRepository userRepository;

	public Neo4jDemoApplication(SongRepository songRepository, MenuRepository menuRepository, UserRepository userRepository) {
		this.songRepository = songRepository;
		this.menuRepository = menuRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Neo4jDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setHobbies(List.of("reading", "walking", "coding"));
		user = userRepository.save(user);
		user = userRepository.findById(user.getId()).get();
		Menu newMenu = new Menu();
		newMenu.setName("新菜单");
		menuRepository.save(newMenu);
		Optional<Menu> foundMenu = menuRepository.findById("62a54c91-6efb-4f09-9209-f98aba1effa2");
		Menu found = foundMenu.get();
		List<Menu> menus = menuRepository.findAll();
		Menu menu = menuRepository.findNested(196L);
		List<Song> songs = songRepository.findAll();
		songs.forEach(System.out::println);
		List<MenuProjection> menudto = menuRepository.findMenuNames();
		menus = menuRepository.findByIds(List.of(196L, 197L));
		List<Menu> menuList = menuRepository.findMenus();
		menus = menuRepository.findMenusByUserId(204L);
		menus.forEach(System.out::println);
	}
}
