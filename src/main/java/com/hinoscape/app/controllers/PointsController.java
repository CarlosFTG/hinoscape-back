package com.hinoscape.app.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hinoscape.app.models.dto.UserDto;
import com.hinoscape.app.models.dto.UserPointDto;
import com.hinoscape.app.models.service.IUserPointService;

@Controller
@SessionAttributes("points")
public class PointsController {
	
	@Autowired
	IUserPointService userPointService;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Secured("ROLE_USER")
	@RequestMapping(value = {"/getUserChallenges"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<List<UserPointDto>> getUserPoints(@RequestParam Long userId) throws JSONException {
		
		return ResponseEntity.ok(this.userPointService.getUserPoints(userId));
	}
}
