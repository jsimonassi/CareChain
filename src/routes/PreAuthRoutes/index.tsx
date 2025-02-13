import React, {useEffect} from 'react';
import {createStackNavigator} from '@react-navigation/stack';
import {PreAuthStackParamList} from '../../types/routes';
import {Login} from '../../screens';
import {useMetaMask} from '../../hooks/useMetamask';

const Stack = createStackNavigator<PreAuthStackParamList>();

export const PreAuthStack = () => {
  const {connectWallet} = useMetaMask();

  useEffect(() => {
    connectWallet();
  }, []);

  return (
    <Stack.Navigator
      screenOptions={{
        headerShown: false,
      }}>
      <Stack.Screen name="Login" component={Login} />
    </Stack.Navigator>
  );
};
