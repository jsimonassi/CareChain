import React from 'react';
import {createStackNavigator} from '@react-navigation/stack';
import {PreAuthStackParamList} from '../../types/routes';
import {Login} from '../../screens';

const Stack = createStackNavigator<PreAuthStackParamList>();

export const PreAuthStack = () => {
  return (
    <Stack.Navigator
      screenOptions={{
        headerShown: false,
      }}>
      <Stack.Screen name="Login" component={Login} />
    </Stack.Navigator>
  );
};
