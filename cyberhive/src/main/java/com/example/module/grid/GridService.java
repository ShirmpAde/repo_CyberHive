package com.example.module.grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GridService {
	
	@Autowired
	GridDao gridDao;
}
