package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.File;
import repositories.FileRepository;
import services.FileService;

@RestController
@RequestMapping("/app/files")
public class FileController {
	private FileService fileService;

	@GetMapping
	public List<File> getAllFiles(@RequestParam Optional<Long> custId) {
		return fileService.getAllFiles(custId);
	}

	@PostMapping
	public File addFile(@RequestBody File file) {
		return fileService.addFile(file);
	}

	@GetMapping("/{fileId}")
	public File getOneFile(@PathVariable Long fileId) {
		return fileService.getOneFile(fileId);
	}

	@PutMapping("/{fileId}")
	public File updateFile(@PathVariable Long fileId, @RequestBody File updatedFiles) {
		return fileService.updateFile(fileId, updatedFiles);
	}

	@DeleteMapping("/{fileId}")
	public void deleteFile(@PathVariable Long fileId) {
		fileService.deleteFile(fileId);
	}
}
