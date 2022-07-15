import { Plan } from "./plans";

export interface CustomResponse {
    timeStamp: Date;
    statusCode: number;
    status: string;
    reason: string;
    message: string;
    developerMessage: string;
    // could be null <?>
    data: { plans?: Plan[], plan?: Plan };
}