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
}
