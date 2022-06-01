package model;

public class HealthCheckLogic {
	public void execute(Health health) {

		double weight = health.getWeight();
		double height = health.getHeight();

		/*if(weight<0) {
			weight=0;
		}
		if(height<0) {
			height=0;
		}*/

		double bmi;
		if(height==0||weight==0) {
			bmi =0;
		}else {
		    bmi =Math.round(weight/(height /100.0*height/100.0));
		}

		health.setBmi(bmi);

		String bodyType;
		if(bmi <18.5) {
			bodyType="瘦せ型";
		}else if(bmi <25) {
			bodyType="普通";
		}else {
			bodyType="肥満";
		}
		health.setBodyType(bodyType);

	}

}
