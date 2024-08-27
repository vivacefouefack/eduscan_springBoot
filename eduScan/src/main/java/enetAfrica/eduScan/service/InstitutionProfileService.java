package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.InstitutionDto;
import enetAfrica.eduScan.model.InstitutionProfile;

public interface InstitutionProfileService {

    /**
     * Adds a new institution profile based on the provided data transfer object.
     *
     * @param profileDto the data transfer object containing details for the new institution profile.
     * @return the added InstitutionProfile.
    */
    public InstitutionProfile addInstitutionProfile(InstitutionDto profileDto);

    /**
     * Deletes an institution profile by its identifier.
     *
     * @param id the identifier of the institution profile to delete.
    */
    public void deleteInstitutionProfileById(Integer id);

    /**
     * Retrieves an institution profile by its identifier.
     *
     * @param id the identifier of the institution profile to retrieve.
     * @return an Iterable of InstitutionProfile.
    */
    public Iterable<InstitutionProfile> getInstitutionProfileById(Integer id);

    /**
     * Updates an existing institution profile based on the provided data transfer object.
     *
     * @param profileDto the data transfer object containing updated details for the institution profile.
     * @return the updated InstitutionProfile.
    */
    public InstitutionProfile updateInstitutionProfile(InstitutionDto profileDto);

    /**
     * Retrieves all institution profiles.
     *
     * @return an Iterable of all InstitutionProfile.
    */
    public Iterable<InstitutionProfile> getAll();
    
}
