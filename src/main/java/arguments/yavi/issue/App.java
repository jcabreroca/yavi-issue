package arguments.yavi.issue;

import am.ik.yavi.arguments.Arguments1Validator;
import am.ik.yavi.builder.ArgumentsValidatorBuilder;
import am.ik.yavi.core.Validated;
import am.ik.yavi.meta.ConstraintArguments;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  @ConstraintArguments
  public String pushOne(String contentMD5) {
    Arguments1Validator<String, String> arguments1Validator = ArgumentsValidatorBuilder.of(this::pushOne)
        .builder(b -> b.constraint(_AppPushOneArgumentsMeta.CONTENTMD5, c -> c.notBlank()))
        .build();

    Validated<String> validate = arguments1Validator.validate(contentMD5);
    if (validate.isValid()) {
      return "ok";
    }
    return "ko";
  }
}
