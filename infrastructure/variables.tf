variable "lambda_s3_bucket" {
  description   = "Name of the S3 bucket where we want to store our code"
  type          = "string"
}

variable "lambda_s3_key" {
#  default       = "redirectshorturl-0.0.1-SNAPSHOT.jar"
  description   = "Object key of the S3 bucket where we want to store our code"
  type          = "string"
}

variable "lambda_function_name" {
  default 	= "url-shortener-redirect-short-url-lambda"
  description 	= "Name we would like to assign to the lambda function"
  type 		= "string"
}

variable "lambda_function_handler" {
  default 	= "URLShortenerRedirectShortURL::apply"
  description 	= "The name of the method invoked in the lambda, given Class::method"
  type 		= "string"
}

variable "iam_for_lambda_arn" {
  description   = "ARN for the IAM role for the lambda"
  type 		= "string"
}

