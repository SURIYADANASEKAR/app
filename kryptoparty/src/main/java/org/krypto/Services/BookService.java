package org.krypto.Services;


import java.util.List;

import org.krypto.model.Hall;
import org.springframework.stereotype.Service;



@Service
public interface BookService {

	List<Hall> addByBookuserAndHallId(long hallId, Hall hallValues);


	List<Hall> getByBookuser(String bookuser);
}