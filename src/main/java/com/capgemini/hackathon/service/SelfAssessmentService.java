package com.capgemini.hackathon.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capgemini.hackathon.model.AssessmentResult;
import com.capgemini.hackathon.model.UserDetails;

@Component
public class SelfAssessmentService implements ISelfAssessmentService{

	
    
    	String diarrhoea[] = {"Stomach Ache","Nausea","Vomiting","Fever","Sudden Weight Loss"};
        String malaria[] = {"Fever","Vomiting","Sweating","Muscle And Body Pain","Headaches"};
        String typhoid[] = {"Fever","Headaches","Weakness/Fatigue","Abdominal Pain","Muscle Pain","Dry Cough","Diarrhoea/Constipation"};
        String diabetes[] = {"Frequent Urination","Hunger","Thirsty Than Usual","Sudden Weight Loss","Blurred Vision","Skin Itching"};
        String blood_pressure[] = {"Headaches","Blurred Vision","Chest Pain","Shortness in Breath","Dizziness","Nausea","Vomiting"};
        String cardio_disease[] = {"Shortness in Breath","Fast Heartbeat","Indigestion","Pressure Or Heaviness In Chest","Anxiety"};
        Map<Integer, String> map = new HashMap<>();
        
        
	@Override
	public AssessmentResult retrieveAssessmentResult(UserDetails userDetails) {
		// TODO Auto-generated method stub
		AssessmentResult results = new AssessmentResult();
		
		
		
		
		return null;
	}
	
	public List<String> evaluate(List<String> symptoms){
	
		map.put(1,"diarrhoea");
    	map.put(2,"malaria");
    	map.put(3,"typhoid");
    	map.put(4,"diabetes");
    	map.put(5,"blood_pressure");
    	map.put(6, "cardio_disease");
    
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
		
 				
		
		
		
		return null;
	}

	
}
