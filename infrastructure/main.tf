module "lambda" {
  source      		   	= "github.com/JamesCollerton/Terraform_Modules//lambda"
  lambda_s3_bucket              = "${var.lambda_s3_bucket}"
  lambda_s3_key                 = "${var.lambda_s3_key}"
  lambda_function_name 		= "${var.lambda_function_name}" 
  lambda_function_handler 	= "${var.lambda_function_handler}" 
  iam_for_lambda_arn 		= "${var.iam_for_lambda_arn}" 
}

