import { DataState } from "./dataState";

// make generic <T>
export interface AppState<T> {
    // determine the state of the app...use to check the state of the app
    //loading, loaded, or error
    dataState: DataState; 
    appData?: T; //contain all the data
    error?: string;
}