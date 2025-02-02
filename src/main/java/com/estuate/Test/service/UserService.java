package com.estuate.Test.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estuate.Test.dto.Users;
import com.estuate.Test.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	 private String getOppositeGender(String gender) {
	        return gender.equalsIgnoreCase("Male") ? "Female" : "Male";
	    }

	public Users createUser(Users user) {
		return repository.save(user);
	}

	
	
	public List<String> getRecommendations(int id) {
		Users user=repository.findById(id).get();
//		String gender=getOppositeGender(user.getGender());
//		List<Users> allUsers=repository.findByGender(gender);
//		
//		allUsers.sort(Comparator.comparingInt(u -> Math.abs(u.getAge() - user.getAge())));
//		
//		allUsers.sort((u1, u2) -> {
//            int sharedInterestsCount1 = getSharedInterestsCount(user, u1);
//            int sharedInterestsCount2 = getSharedInterestsCount(user, u2);
//            return Integer.compare(sharedInterestsCount2, sharedInterestsCount1); // More shared interests comes first
//        });
//		return allUsers;
		
		return repository.findByGender(getOppositeGender(user.getGender())).stream()
                // Step 2: Sorting by shared interests (descending order)
                .sorted((u1, u2) -> Integer.compare(getSharedInterestsCount(user, u2), getSharedInterestsCount(user, u1))) 
                // Step 3: Sorting by age proximity (ascending order)
                .sorted(Comparator.comparingInt(u -> Math.abs(u.getAge() - user.getAge())))
                // Step 4: Limit to top 2 results
                .limit(2)
                .map(Users::getName)
                // Collect the results into a list
                .collect(Collectors.toList());
	}
	
	private int getSharedInterestsCount(Users user, Users allUser) {
        List<String> currentUserInterests = user.getInterest();
        List<String> potentialMatchInterests = allUser.getInterest();

        // Calculate the intersection (common interests)
        Set<String> currentUserInterestsSet = new HashSet<>(currentUserInterests);
        Set<String> potentialMatchInterestsSet = new HashSet<>(potentialMatchInterests);

        // Retain only the common interests
        currentUserInterestsSet.retainAll(potentialMatchInterestsSet);

        return currentUserInterestsSet.size(); // Return the number of shared interests
    }}
