package abc.univ.repos;

import abc.univ.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Long> {
    List<Question> getQuestionsByCategoryAndSubcategory(String cat, String subcat);
}