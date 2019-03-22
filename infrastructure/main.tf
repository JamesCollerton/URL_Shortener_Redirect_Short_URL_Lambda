module "lambda" {
  source      		   	= "github.com/JamesCollerton/Terraform_Modules//lambda"
  lambda_function_filename 	= "${var.lambda_function_filename}" 
  lambda_function_name 		= "${var.lambda_function_name}" 
  lambda_function_handler 	= "${var.lambda_function_handler}" 
}

