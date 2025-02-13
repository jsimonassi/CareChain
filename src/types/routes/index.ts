import {ParamListBase} from '@react-navigation/native';

export interface PreAuthStackParamList extends ParamListBase {
  Login: undefined;
}

export interface PostAuthStackParamList extends ParamListBase {
  Home: undefined;
}
