package personal.learning.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@RequestMapping(value = "/checkStatus", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity checkStatus(@RequestParam("format") String format) {
		if(format == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		switch(format) {
		case "small":
			return ResponseEntity.ok(new StatusController.StatusInfo("OK"));
		case "big":
			Instant now = Instant.now();
			return ResponseEntity.ok(new StatusController.ResponseInfo(now, "OK"));
		default:
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/create/status")
	@ResponseBody
	public ResponseEntity createStatus() {
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@PutMapping("/update/status")
	@ResponseBody
	public ResponseEntity updateStatua() {
		return ResponseEntity.unprocessableEntity().build();
	}
	
	@DeleteMapping("/delete/status")
	@ResponseBody
	public ResponseEntity deleteStatus() {
		return ResponseEntity.unprocessableEntity().build();
	}
	
	public static class ResponseInfo {
		private Instant currentTime;
		private String status;
		
		public ResponseInfo(Instant currentTime, String status) {
			this.currentTime = currentTime;
			this.status = status;
		}

		public ResponseInfo(String status) {
			this.status = status;
		}

		public Instant getCurrentTime() {
			return currentTime;
		}

		public String getStatus() {
			return status;
		}
	}
	
	public static class StatusInfo {
		private String status;

		public StatusInfo(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}
	}
}
