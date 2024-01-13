package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import models.File;
import repositories.FileRepository;

@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;

	public List<File> getAllFiles(Optional<Long> custId) {
		if (custId.isPresent()) {
			return fileRepository.findByUserId(custId.get());
		}
		return fileRepository.findAll();
	}

	public File getOneFile(Long fileId) {
		return fileRepository.findById(fileId).orElse(null);
	}

	public File addFile(File file) {
		return fileRepository.save(file);
	}

	public File updateFile(Long fileId, File updatedFile) {
		Optional<File> file = fileRepository.findById(fileId);
		if (file.isPresent()) {
			File foundFile = file.get();
			foundFile.setFileName(updatedFile.getFileName());
			fileRepository.save(foundFile);
			return foundFile;
		} else {
			return null;
		}

	}

	public void deleteFile(Long fileId) {
		fileRepository.deleteById(fileId);

	}

}
