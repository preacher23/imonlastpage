package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Publisher;

public interface PublisherService {
	 List<Publisher> getAllPublishers();

	    Object getPublisherById(int publisherId);

	    Publisher savePublisher(Publisher publisher);

	    String deletePublisher(int publisherId);

	    Object fullUpdate( int publisherId,Publisher publisher);

	    Object partialUpdate(int publisherId, Publisher publisher);
}
