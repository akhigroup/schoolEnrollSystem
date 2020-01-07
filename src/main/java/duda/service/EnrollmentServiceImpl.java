package duda.service;

import duda.domain.Pupil;
import duda.domain.School;
import duda.utilities.Haversine;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final SchoolService schoolService;
    private final PupilService pupilService;

    public EnrollmentServiceImpl(SchoolService schoolService, PupilService pupilService) {
        this.schoolService = schoolService;
        this.pupilService = pupilService;
    }

    public void enrollPupil(Long pupilId) {
        Pupil pupilToEnroll = pupilService.getById(pupilId);

        // לבדוק את המרחק ולדרג את הבתי ספר לפי זה או סוג של למיין
        // לאחר מכן, לבדוק את שאר הנתונים. האם מספיק הממוצע, והאם יש מקום בבית ספר
        // הבצפר הראשון שעולה על כל הקריטריונים ביחד הוא הנבחר
        // לשמור בית ספר בדיבי של התלמיד
    }

     private Map<School, Double> FormulaResult(Pupil pupilToEnroll) {
            Map<School, Double> formulaResults = schoolService.findAll().stream()
                    .collect(Collectors.toMap
                            (school -> school,
                                    school -> (Double)(getNumberOfPupilFriendsInSchool(pupilToEnroll, school) *
                                            1 / getDistanceFromSchool(pupilToEnroll, school))));

            return formulaResults;
     }

    private int getNumberOfPupilFriendsInSchool(Pupil pupil, School school) {
        return (int) pupil.getFriends().stream().
                map(Pupil::getSchool).
                filter(school1 -> school.getId().equals(school.getId())).
                count();
    }

    private double getDistanceFromSchool(Pupil pupil, School school) {
        return Haversine.
                distance(pupil.getLat(), pupil.getLat(),
                        school.getLat(), school.getLon());
    }

    private boolean canPupilEnrollToSchool(Pupil pupil, School school) {
        return pupil.getGPA() >=school.getMinimumGpa() &&
                numberRegisteredtoSchool(school) <= school.getMaxNumberOfPupils();
    }

    private int numberRegisteredtoSchool(School s) {
       return (int) pupilService.findAll().stream().
                map(pupil -> pupil.getSchool()).
                count();
    }
}
