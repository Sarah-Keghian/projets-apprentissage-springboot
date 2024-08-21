package fr.sarke.db_for_de.repository;

import fr.sarke.db_for_de.model.De;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeRepo extends JpaRepository<De, Long> {
}
