package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.InstitutionProfile;

public interface InstitutionProfileService {

    /**
     * 
     * @param profileDto
     * @return
     */
    public InstitutionProfile addInstitutionProfile(PropectionRecordDto profileDto);


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
    public InstitutionProfile updateInstitutionProfile(PropectionRecordDto profileDto);

    /**
     * 
     * @return
     */
    public Iterable<InstitutionProfile> getAll();
    
}
