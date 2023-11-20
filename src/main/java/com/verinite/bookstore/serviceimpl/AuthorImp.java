package com.verinite.bookstore.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Author;
import com.verinite.bookstore.repository.AuthorRepository;
import com.verinite.bookstore.service.AuthorService;

@Service

public class AuthorImp implements AuthorService {
	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	AuthorService authorService;

	@Override
	// TO-Add-Author-Into-Repository
	public Author saveAuthor(Author author) {
		author.setCreatedOn(new Date());
		author.setUpdatedOn(new Date());
		author.setDeleted(false);
		return authorRepo.save(author);
	}

	@Override
	// To-Get-All-The-Authors-Present-In-Repo
	public List<Author> allAuthors() {
		return authorRepo.all();
	}

	@Override
	// To-Get-The-Author-By-Id
	public Object getById(int authorId) {

		try {
			authorRepo.findById(authorId).get();
			return authorRepo.getById(authorId);
		} catch (Exception e) {
			return authorId+"this Id not Found in record";
		}

	}

	@Override
	// To-Delete-Author-By-Id
	public String deleteAuthorById(int authorId) {
		try {
			Author authorEntity = authorRepo.findById(authorId).get();
			if (!authorEntity.isDeleted()) {
				authorEntity.setDeleted(true);
				authorEntity.setCreatedOn(new Date());
				authorRepo.save(authorEntity);

				return "Author record Successfully deleted";
			} else {
				return "Given authorId is already deleted";
			}
		} catch (Exception e) {
			return "Id not Found";
		}

	}

	@Override
	// To-Update-Author-FirstNmae-And-LastName
	public Object updateAuthor(int authorId, Author author) {

		try {
			Author authorEntity = authorRepo.findById(authorId).get();
			boolean b = authorEntity.isDeleted();
			if (!b) {
				authorEntity.setUpdatedOn(new Date());
				authorEntity.setFirstName(author.getFirstName());
				authorEntity.setLastName(author.getLastName());

				final Author up = authorRepo.save(authorEntity);
				return ResponseEntity.ok(up);
			} else {
				return "The given authorId already deleted,So we cant update-it";
			}

		} catch (Exception e) {
			return "Id not Found";
		}

	}
	
	@Override
	public List<Author> getByFirstName(String firstName) {
			return authorRepo.getByFirstName(firstName);
	}
	
//	@Override
//	// To-Update-Author-FirstNmae-And-LastName
//	public Optional<Object> updateAuthor(int authorId, Author author) {
//
//		try {
//			Author authorEntity = authorRepo.findById(authorId).get();
//			boolean b = authorEntity.isDeleted();
//			if (!b) {
//				authorEntity.setUpdatedOn(new Date());
//				authorEntity.setFirstName(author.getFirstName());
//				authorEntity.setLastName(author.getLastName());
//
//				return Optional.empty();
//			} else {
//				return Optional.ofNullable("The given authorId already deleted,So we cant update-it");
//			}
//
//		} catch (Exception e) {
//			return Optional.ofNullable("Id not Found");
//		}
//
//	}

}
