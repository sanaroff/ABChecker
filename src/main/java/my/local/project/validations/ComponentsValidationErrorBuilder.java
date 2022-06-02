package my.local.project.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ComponentsValidationErrorBuilder {

    public static ComponentsValidationError fromBindingErrors(Errors errors) {
        ComponentsValidationError error = new ComponentsValidationError("Validation failed. "  + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        return error;
    }
}
