package com.hostelassist.complaints;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    // GET all complaints
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return ComplaintServer.getComplaints();
    }

    // POST a complaint (Postman / React)
    @PostMapping(consumes = "application/json")
    public String addComplaint(@RequestBody Complaint complaint) {

        // auto-increment id
        complaint.setId(ComplaintServer.getComplaints().size() + 1);

        // store in shared list
        ComplaintServer.getComplaints().add(complaint);

        return "Complaint recorded successfully " + "Complaint id " + complaint.getId();
    }

    // DELETE complaint by id
    @DeleteMapping("/{id}")
    public String deleteComplaint(@PathVariable int id) {

        boolean removed = ComplaintServer.getComplaints()
                .removeIf(c -> c.getId() == id);

        if (removed) {
            return "Complaint deleted successfully";
        } else {
            return "Complaint not found";
        }
    }
}
