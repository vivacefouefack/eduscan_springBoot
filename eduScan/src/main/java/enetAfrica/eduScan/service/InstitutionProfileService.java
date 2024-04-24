package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.InstitutionDto;
import enetAfrica.eduScan.model.InstitutionProfile;

public interface InstitutionProfileService {

    /**
     * 
     * @param profileDto
     * @return
     */
    public InstitutionProfile addInstitutionProfile(InstitutionDto profileDto);


    /**
     * 
     * @param id
     */
    public void deleteInstitutionProfileById(Integer id);

    /**
     * 
     * @param id
     * @return 
     */
    public InstitutionProfile getInstitutionProfileById(Integer id);

    /**
     * 
     * @param profileDto
     * @return
     */
    public InstitutionProfile updateInstitutionProfile(InstitutionDto profileDto);

    /**
     * 
     * @return
     */
    public Iterable<InstitutionProfile> getAll();
    
}
