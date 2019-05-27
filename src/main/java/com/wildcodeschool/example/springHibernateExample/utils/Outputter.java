package com.wildcodeschool.example.springHibernateExample.utils;

import com.wildcodeschool.example.springHibernateExample.entities.User;
import com.wildcodeschool.example.springHibernateExample.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Outputter implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger("Wilder");

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD
        logger.info("******************");
        logger.info("Objects in DB : " + userRepository.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        User user1 = new User("Brenda", "Wildeuse", 19);
        logger.info("******************");
        logger.info(user1 + " has been created !");
        userRepository.save(user1);
        logger.info(user1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        User user2 = new User("Brandon", "Wilder", 33);
        logger.info("******************");
        logger.info(user2 + " has been created !");
        userRepository.save(user2);
        logger.info(user2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        User tempUser = userRepository.findById(2L).get();

        logger.info("******************");
        logger.info("Second user's firstname is " + tempUser.getFirstName());
        logger.info("Second user's lastname is " + tempUser.getLastName());
        logger.info("Second user's age is " + tempUser.getAge());

        // Liste les utilisateurs enregistrés dans la BDD
        logger.info("******************");
        logger.info("Users in list are ");
        for (User myUser : userRepository.findAll()) {
            logger.info(myUser.toString());
        }

        // Supprime le second utilisateur de la BDD
        userRepository.deleteById(2L);

        // Liste les utilisateurs enregistrés dans la BDD (permet de vérifier que le second utilisateur a bien été supprimé de la BDD)
        logger.info("******************");
        logger.info("User in list are ");
        for (User myUser : userRepository.findAll()) {
            logger.info(myUser.toString());
        }
    }
}

