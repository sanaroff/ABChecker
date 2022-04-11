/**
 * Copyright (C) 2022, 1C
 */
package my.local.project.repository;

import my.local.project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hermezzis
 *
 */

public interface ClientRepository extends JpaRepository<Client, Long> {

    /*@Query("select abonement.name from abonement a INNER JOIN user ON abonement.Client=user.ID")
    public Iterable<Abonement> getAllAbonementByClient(Long ID);*/
}
