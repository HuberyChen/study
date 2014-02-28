package pratice.test;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author hubery.chen
 */
public class DomainTest {

    @Test
    public void lengthTest() {
        Domain domain = new Domain();
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Domain>> set = validator.validate(domain);
        for (ConstraintViolation<Domain> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }
    }

    public class Domain {
        @Valid
//        @NotNull(message = "The name can not be null")
        @NotEmpty(message = "The name can not be null")
        private String name;

        @Size(min = 1, max = 10, message = "The age must between 1 and 10")
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
