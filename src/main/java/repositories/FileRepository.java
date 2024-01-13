package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.File;

public interface FileRepository extends JpaRepository<File, Long> {

	List<File> findByUserId(Long id);

}
