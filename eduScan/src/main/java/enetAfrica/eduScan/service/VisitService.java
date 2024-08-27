package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;
import jakarta.validation.Valid;

public interface VisitService {

    /**
     * Adds a new visit to the system.
     *
     * @param visitDto the data transfer object containing visit details.
     * @return the newly added Visit.
    */
    public Visit addVisit(VisitDto visitDto);

    /**
     * Updates an existing visit in the system.
     *
     * @param visitDto the data transfer object containing updated visit details.
     * @return the updated Visit.
    */
    public Visit updateVisit(VisitDto visitDto);

    /**
     * Deletes a visit from the system by its identifier.
     *
     * @param id the identifier of the visit to be deleted.
    */
    public void deleteVisit(Integer id);

    /**
     * Retrieves a visit by its identifier.
     *
     * @param id the identifier of the visit to retrieve.
     * @return an Iterable containing the visits with the specified identifier.
    */
    public Iterable<Visit> getVisitById(Integer id);

    /**
     * Retrieves all visits from the system.
     *
     * @return an Iterable containing all visits.
    */
    public Iterable<Visit> getAllVisit();

    /**
     * Validates and updates the status of a visit by its identifier.
     *
     * @param id the identifier of the visit to validate.
     * @return the validated Visit.
    */
    public Visit valideVisitById(@Valid int id);

    /**
     * Validates a visit by its identifier.
     *
     * @param id the identifier of the visit to validate.
     * @return the validated Visit.
    */
    public Visit valide(@Valid int id);

}
