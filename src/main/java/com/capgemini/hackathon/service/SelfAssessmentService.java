package com.capgemini.hackathon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capgemini.hackathon.filter.AuthorizationFilter;
import com.capgemini.hackathon.model.AssessmentResult;
import com.capgemini.hackathon.model.PossibleDisease;
import com.capgemini.hackathon.model.UserDetails;
import com.capgemini.hackathon.util.SelfAssessmentConstants;

@Component
public class SelfAssessmentService implements ISelfAssessmentService{

	
    
    	String diarrhoea[] = {"Stomach Ache","Nausea","Vomiting","Fever","Sudden Weight Loss"};
        String malaria[] = {"Fever","Vomiting","Sweating","Muscle And Body Pain","Headaches"};
        String typhoid[] = {"Fever","Headaches","Weakness/Fatigue","Abdominal Pain","Muscle Pain","Dry Cough","Diarrhoea/Constipation"};
        String diabetes[] = {"Frequent Urination","Hunger","Thirsty Than Usual","Sudden Weight Loss","Blurred Vision","Skin Itching"};
        String blood_pressure[] = {"Headaches","Blurred Vision","Chest Pain","Shortness in Breath","Dizziness","Nausea","Vomiting"};
        String cardio_disease[] = {"Shortness in Breath","Fast Heartbeat","Indigestion","Pressure Or Heaviness In Chest","Anxiety"};
        Map<Integer, String> map = new HashMap<>();
        private static Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);
        
	@Override
	public AssessmentResult retrieveAssessmentResult(UserDetails userDetails) {
		// TODO Auto-generated method stub
		logger.info("Inside retrieveAssessmentResult");
		AssessmentResult results = new AssessmentResult();
		
		List<String> diseases = evaluate(userDetails.getSymptoms());
		results.setName(userDetails.getName());
		results.setAge(userDetails.getAge());
		
		PossibleDisease possibleDisease = null;
		
		for(String disease : diseases) {
			possibleDisease = new PossibleDisease();
			possibleDisease.setDisease(disease);
			// TODO: get the causes and Preventions and add it in response
			possibleDisease = fetchCausesAndPreventions(possibleDisease);
			results.getPossibleDiseases().add(possibleDisease);	
		}
		
		return results;
	}
	
	public List<String> evaluate(List<String> symptoms){
		logger.info("Inside evaluate");
		map.put(0,"diarrhoea");
    	map.put(1,"malaria");
    	map.put(2,"typhoid");
    	map.put(3,"diabetes");
    	map.put(4,"blood_pressure");
    	map.put(5, "cardio_disease");
    	List<String> diseases = new ArrayList<String>();
        
		int numberOfSymptoms = symptoms.size();
		//int diseaseCount = 
		int[] c = new int[20];
		
		for(int i=0; i<numberOfSymptoms; i++) {
			
			for( int j=0; j<6; j++){
				 switch (j)
                 {
                     case 1 : {
                             int l = 0;
                             l = diarrhoea.length;
                             for(int k=0 ; k<l ; k++ )
                             {
                                 if(symptoms.get(i).equals(diarrhoea[k]) )
                                 {
                                     c[0]++;
                                 }
                             }
                                 break; }

                     case 2: {
                         int l = 0;
                         l = malaria.length;
                         for (int k = 0; k < l; k++) {
                             if (symptoms.get(i).equals(malaria[k])) {
                                 c[1]++;
                             }
                         }
                         break;
                     }

                     case 3: {
                         int l = 0;
                         l = typhoid.length;
                         for (int k = 0; k < l; k++) {
                             if (symptoms.get(i).equals(typhoid[k])) {
                                 c[2]++;
                             }
                         }
                         break;
                     }

                     case 4: {
                         int l = 0;
                         l = diabetes.length;
                         for (int k = 0; k < l; k++) {
                             if (symptoms.get(i).equals(diabetes[k])) {
                                 c[3]++;
                             }
                         }
                         break;
                     }

                     case 5: {
                         int l = 0;
                         l = blood_pressure.length;
                         for (int k = 0; k < l; k++) {
                             if (symptoms.get(i).equals(blood_pressure[k])) {
                                 c[4]++;
                             }
                         }
                         break;
                     }

                     case 6: {
                         int l = 0;
                         l = cardio_disease.length;
                         for (int k = 0; k < l; k++) {
                             if (symptoms.get(i).equals(cardio_disease[k])) {
                                 c[5]++;
                             }
                         }
                         break;
                     }
                 }
			}
		}
		
		int max = c[0];
		int diseaseKey = 0;
        for( int m=0; m<6 ; m++)
        {
            if(c[m] > max) {
                max = c[m];
                diseaseKey = m;
            }
        }
        
        
        logger.info("Disease Name :{}",map.get(diseaseKey));
        diseases.add(map.get(diseaseKey));
		
		return diseases;
	}
	
	private PossibleDisease fetchCausesAndPreventions(PossibleDisease disease) {
		switch (disease.getDisease()) {

		case "diarrhoea": {
			mapData(SelfAssessmentConstants.DIARRHOEA_CAUSES, SelfAssessmentConstants.DIARRHOEA_PREVENTION, disease);
			break;
		}

		case "malaria": {
			mapData(SelfAssessmentConstants.MALERIA_CAUSES, SelfAssessmentConstants.MALERIA_PREVENTION, disease);
			break;
		}
		case "typhoid": {
			mapData(SelfAssessmentConstants.TYPHOID_CAUSES, SelfAssessmentConstants.TYPHOID_PREVENTION, disease);
			break;
		}

		case "diabetes": {
			mapData(SelfAssessmentConstants.DIABETES_CAUSES, SelfAssessmentConstants.DIABETES_PREVENTION, disease);
			break;
		}

		case "blood_pressure": {
			mapData(SelfAssessmentConstants.BLOOD_PRESSURE_CAUSES, SelfAssessmentConstants.BLOOD_PRESSURE_PREVENTION, disease);
			break;
		}

		case "cardio_disease": {
			mapData(SelfAssessmentConstants.CARDIO_DISEASE_CAUSES, SelfAssessmentConstants.CARDIO_DISEASE_PREVENTION, disease);
			break;
		}

		}
		return disease;

	}
	
	private PossibleDisease mapData(String causes, String preventions, PossibleDisease possibleDisease) {
		List<String> causesList = new ArrayList<String>();
		List<String> preventionsList = new ArrayList<String>();
		
		
		String[] cList= causes.split("\\|");
		String[] pList = preventions.split("\\|");
		
		for(String cause : cList) {
			causesList.add(cause);
		}
		for(String prevention : pList) {
			preventionsList.add(prevention);
		}
		possibleDisease.setCauses(causesList);
		possibleDisease.setPrevention(preventionsList);
		return possibleDisease;
	}

	
}
