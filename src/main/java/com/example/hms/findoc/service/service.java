package com.example.hms.findoc.service;

import java.util.List;
import java.util.Optional;

import com.example.hms.findoc.entity.DoctorCard;
import com.example.hms.findoc.entity.DoctorDetails;
import com.example.hms.findoc.entity.EventsDetails;
import com.example.hms.findoc.entity.HospitalCard;
import com.example.hms.findoc.entity.HospitalDetails;
import com.example.hms.findoc.entity.SpecialityCard;
import com.example.hms.findoc.entity.User;

public interface service {
	List<User> getAllDetails();

    User postAllDetails(User user);
    User findByEmail(String mail);
    

	Optional<DoctorCard> findById(int n);

	List<DoctorCard> getAllDoctorCard();

	void postDoctorCardItems(DoctorCard d);

	Optional<DoctorCard> getDoctorCardById(int n);

	List<DoctorDetails> getDetailDoctor();

	void postDetailDoctor(DoctorDetails d);

	Optional<DoctorDetails> getById(int n);

	List<HospitalCard> findHospitalCard();

	void postCardHosital(HospitalCard hc);

	Optional<HospitalCard> ByFindId(int n);

	List<HospitalDetails> GetHospitalDetails();

	void insertDetailsHospital(HospitalDetails h);

	Optional<HospitalDetails> selectById(int n);

	List<SpecialityCard> getSpecialityCard();

	void postCardSpeciality(SpecialityCard s);

	Optional<SpecialityCard> SpecialityById(int n);

	List<EventsDetails> getAllEvents();

	EventsDetails getEventById(int id);

	EventsDetails createEvent(EventsDetails eventDetails);
}
